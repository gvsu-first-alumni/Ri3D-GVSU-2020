package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class ChangeFrontCommand implements Command
{
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final Set<Subsystem>      subsystems;

    public ChangeFrontCommand(DriveTrainSubsystem driveTrainSubsystem)
    {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.subsystems = Set.of(driveTrainSubsystem);
    }

    @Override
    public void initialize()
    {
        driveTrainSubsystem.setForward(!driveTrainSubsystem.isForward());
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return true; // 1 run command
    }

    @Override
    public void end(boolean interrupted)
    {

    }

    @Override
    public Set<Subsystem> getRequirements()
    {
        return this.subsystems;
    }
}
