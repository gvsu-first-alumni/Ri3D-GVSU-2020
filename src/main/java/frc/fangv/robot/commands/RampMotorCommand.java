package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.fangv.robot.subsystems.RampSubsystem;


public class RampMotorCommand extends CommandBase {
    private final RampSubsystem rampSubsystem;

    public RampMotorCommand(RampSubsystem rampSubsystem) {
        this.rampSubsystem = rampSubsystem;
        addRequirements(rampSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() { RampSubsystem.getInstance().forward(); }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) { RampSubsystem.getInstance().stop(); }
}
