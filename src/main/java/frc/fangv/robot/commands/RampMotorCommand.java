package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.RampSubsystem;
import java.util.Set;


public class RampMotorCommand implements Command
{
    private final RampSubsystem rampSubsystem;
    private final Set<Subsystem> subsystems;

    public RampMotorCommand(RampSubsystem rampSubsystem) {
        this.rampSubsystem = rampSubsystem;
        this.subsystems = Set.of(rampSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        //System.out.println("RAMPAPPAPAPAPP");
        this.rampSubsystem.forward(); }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) { this.rampSubsystem.stop(); }

    @Override
    public Set<Subsystem> getRequirements() { return this.subsystems; }
}
