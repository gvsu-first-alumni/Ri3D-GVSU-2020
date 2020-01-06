package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;
import frc.fangv.robot.FangvPIDController;
import frc.fangv.robot.subsystems.ControlPanelSubsystem;
import frc.fangv.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class ControlPanelSpinDistanceCommand implements Command {
    private final ControlPanelSubsystem controlPanelSubsystem;
    private final Set<Subsystem> subsystems;

    private double distanceBetweenColors = 0;

    public double getDistanceBetweenColors() {
        return distanceBetweenColors;
    }

    public void setDistanceBetweenColors(double distanceBetweenColors) {
        this.distanceBetweenColors = distanceBetweenColors;
    }

    private FangvPIDController panelPID;

    

    public ControlPanelSpinDistanceCommand(ControlPanelSubsystem controlPanelSubsystem, double distanceBetweenColors) {
        this.distanceBetweenColors = distanceBetweenColors;
        this.controlPanelSubsystem = controlPanelSubsystem;
        this.subsystems = Set.of(controlPanelSubsystem);
        panelPID = new FangvPIDController(100, -100, Constants.CONTROL_PANEL_PID_P,
                Constants.CONTROL_PANEL_PID_I, Constants.CONTROL_PANEL_PID_D, 0);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        controlPanelSubsystem.Set(panelPID.process(distanceBetweenColors, controlPanelSubsystem.getPos()));
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        if (distanceBetweenColors < controlPanelSubsystem.getPos())
            return true;
        else
            return false;
    }

    @Override
    public void end(boolean interrupted) {
        controlPanelSubsystem.Stop();
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
