package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.HookAndWinchSubsystem;

import java.util.Set;

public class WinchMotorForwardCommand implements Command {
    private final HookAndWinchSubsystem hookAndWinchSubsystem;
    private final Set<Subsystem> subsystems;

    public WinchMotorForwardCommand(HookAndWinchSubsystem hookAndWinchSubsystem) {
        this.hookAndWinchSubsystem = hookAndWinchSubsystem;
        this.subsystems = Set.of(hookAndWinchSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        hookAndWinchSubsystem.forward();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        hookAndWinchSubsystem.stop();
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
