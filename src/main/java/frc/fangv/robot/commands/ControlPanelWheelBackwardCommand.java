package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.fangv.robot.subsystems.ControlPanelSubsystem;

public class ControlPanelWheelBackwardCommand extends Command {

    public ControlPanelWheelBackwardCommand() {
        // If any subsystems are needed, you will need to pass them into the requires() method
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        ControlPanelSubsystem.getInstance().Backward();
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end() {
        ControlPanelSubsystem.getInstance().Stop();
    }

    @Override
    protected void interrupted() {

    }
}