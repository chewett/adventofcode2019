package net.chewett.adventofcode2019.intcode;

import net.chewett.adventofcode2019.intcode.exceptions.UnsupportedIntcodeInstruction;
import net.chewett.adventofcode2019.intcode.instructions.IntcodeInstruction;

import java.util.*;

public class IntcodeComputer {

    private Map<Integer, IntcodeInstruction> instructionSet = new HashMap<>();
    private IntcodeComputerMemory memory = new IntcodeComputerMemory();
    private int currentAddress = 0;
    private List<Integer> output = new ArrayList<>();
    private Queue<Integer> input = new LinkedList<>();

    public IntcodeComputer(List<IntcodeInstruction> instructions) {
        for(IntcodeInstruction i : instructions) {
            if(this.instructionSet.containsKey(i.getIntcodeInstructionNumber())) {
                throw new RuntimeException("Two instructions supplied mapping to the same net.chewett.adventofcode2019.intcode.Intcode Instruction");
            }

            this.instructionSet.put(i.getIntcodeInstructionNumber(), i);
        }
    }

    private void initMemory(Intcode intcode) {
        this.memory.loadIntcode(intcode);
    }

    public int runIntcode(Intcode intcode) {
        //Init the memory and set the current address to 0
        this.initMemory(intcode);
        this.currentAddress = 0;

        boolean finishedIntcode = false;
        while(!finishedIntcode) {
            IntcodeInstruction i = this.fetchInstructionAtCurrentAddress();
            //DEBUG: System.out.println("Running " + i);
            finishedIntcode = i.performInstructionOnMemory(this, this.currentAddress, this.memory);
            this.currentAddress += i.getIntsConsumed();
        }

        //Final result is at address 0
        return this.memory.getIntAtAddress(0);
    }

    private IntcodeInstruction fetchInstructionAtCurrentAddress() {
        int instructionModeValue = this.memory.getIntAtAddress(this.currentAddress);
        int modeSettings = (int)Math.floor(instructionModeValue / 100.0);
        int intcodeInstructionId = instructionModeValue % 100;
        //TODO: Add parameter modes in here, MOD 100 for instruction ID

        if(!this.instructionSet.containsKey(intcodeInstructionId)) {
            throw new UnsupportedIntcodeInstruction(intcodeInstructionId);
        }

        IntcodeInstruction i = this.instructionSet.get(intcodeInstructionId);
        i.configureMode(modeSettings);

        return i;
    }

    public void addOutputString(int i) {
        this.output.add(i);
    }

    public List<Integer> getOutput() {
        return this.output;
    }

    public void addToInput(int input) {
        this.input.add(input);
    }

    public int getInput() {
        return this.input.remove();
    }

}
