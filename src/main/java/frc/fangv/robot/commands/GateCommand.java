package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.RampSubsystem;
import java.util.Set;


public class GateCommand implements Command
{
    private final RampSubsystem rampSubsystem;
    private final Set<Subsystem> subsystems;

    public GateCommand(RampSubsystem rampSubsystem) {
        this.rampSubsystem = rampSubsystem;
        this.subsystems = Set.of(rampSubsystem);
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

    @Override
    public Set<Subsystem> getRequirements() { return this.subsystems; }
}
