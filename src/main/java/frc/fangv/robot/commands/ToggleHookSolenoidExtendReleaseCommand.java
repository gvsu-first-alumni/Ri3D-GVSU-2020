package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.HookAndWinchSubsystem;

import java.util.Set;

public class ToggleHookSolenoidExtendReleaseCommand implements Command {
    private final HookAndWinchSubsystem hookAndWinchSubsystem;
    private final Set<Subsystem> subsystems;

    public ToggleHookSolenoidExtendReleaseCommand(HookAndWinchSubsystem hookAndWinchSubsystem) {
        this.hookAndWinchSubsystem = hookAndWinchSubsystem;
        this.subsystems = Set.of(hookAndWinchSubsystem);
    }

    @Override
    public void initialize() {
        if(HookAndWinchSubsystem.getInstance().isFired()){ hookAndWinchSubsystem.release();}
        else {hookAndWinchSubsystem.fire();}
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
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
