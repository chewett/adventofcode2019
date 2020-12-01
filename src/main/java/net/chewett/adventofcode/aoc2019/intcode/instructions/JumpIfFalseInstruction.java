package net.chewett.adventofcode.aoc2019.intcode.instructions;

import net.chewett.adventofcode.aoc2019.intcode.IntcodeComputer;
import net.chewett.adventofcode.aoc2019.intcode.IntcodeComputerMemory;
import net.chewett.adventofcode.aoc2019.intcode.ParameterMode;
import net.chewett.adventofcode.aoc2019.intcode.instructionreturns.IntcodeInstructionReturn;
import net.chewett.adventofcode.aoc2019.intcode.instructionreturns.MoveCurrentAddressPointerInstructionReturn;

public class JumpIfFalseInstruction extends TwoParameterInstruction {

    @Override
    public long getIntcodeInstructionNumber() {
        return 6;
    }

    @Override
    public IntcodeInstructionReturn performInstructionOnMemory(IntcodeComputer icc, int currentAddress, IntcodeComputerMemory memory) {
        long valueToCheck = this.getValueOfOperand(icc, memory, currentAddress + 1, this.operandAMode);

        if(valueToCheck == 0) {
            int newPointerAddress = (int)this.getValueOfOperand(icc, memory, currentAddress + 2, this.operandBMode);
            return new MoveCurrentAddressPointerInstructionReturn(newPointerAddress);
        }

        return new MoveCurrentAddressPointerInstructionReturn(currentAddress + this.getIntsConsumed());
    }

    @Override
    public String getInstructionDetails(IntcodeComputer icc, int currentAddress, IntcodeComputerMemory memory) {
        return "JumpIfFalseInstruction(" +
                "ToCheck=" + ParameterMode.getModename(this.operandAMode) + ":" + memory.getIntAtAddress(currentAddress + 1) +
                "ToJumpTo=" + ParameterMode.getModename(this.operandBMode) + ":" + memory.getIntAtAddress(currentAddress + 2) +
                ")";
    }

}
