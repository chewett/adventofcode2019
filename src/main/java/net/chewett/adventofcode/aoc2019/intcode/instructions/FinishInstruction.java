package net.chewett.adventofcode.aoc2019.intcode.instructions;

import net.chewett.adventofcode.aoc2019.intcode.IntcodeComputer;
import net.chewett.adventofcode.aoc2019.intcode.IntcodeComputerMemory;
import net.chewett.adventofcode.aoc2019.intcode.instructionreturns.FinishedOperationInstructionReturn;
import net.chewett.adventofcode.aoc2019.intcode.instructionreturns.IntcodeInstructionReturn;

public class FinishInstruction extends IntcodeInstruction {


    @Override
    public int getIntsConsumed() {
        return 1;
    }

    @Override
    public long getIntcodeInstructionNumber() {
        return 99;
    }

    @Override
    public IntcodeInstructionReturn performInstructionOnMemory(IntcodeComputer icc, int currentAddress, IntcodeComputerMemory memory) {
        return new FinishedOperationInstructionReturn();
    }

    @Override
    public void configureMode(int modeSetting) {
        //Do nothing
    }

    @Override
    public String getInstructionDetails(IntcodeComputer icc, int currentAddress, IntcodeComputerMemory memory) {
        return "FinishInstruction()";
    }
}
