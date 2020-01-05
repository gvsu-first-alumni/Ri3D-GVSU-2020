package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.fangv.robot.subsystems.RampSubsystem;


public class GateCommand extends CommandBase {
    private final RampSubsystem rampSubsystem;

    public GateCommand(RampSubsystem rampSubsystem) {
        this.rampSubsystem = rampSubsystem;
        addRequirements(rampSubsystem);
    }

    @Override
    public void initialize() {
        if(RampSubsystem.getInstance().isOpen())
            RampSubsystem.getInstance().close();
        else
            RampSubsystem.getInstance().open();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
