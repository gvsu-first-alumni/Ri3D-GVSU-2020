package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;
import frc.fangv.robot.FangvPIDController;
import frc.fangv.robot.subsystems.ControlPanelSubsystem;

import java.lang.invoke.ConstantCallSite;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControlPanelSpinDistanceCommand implements Command {
    private final ControlPanelSubsystem controlPanelSubsystem;
    private final Set<Subsystem> subsystems;

    private String color;
    private Map<String, Map<String, Double>> colors;

    private Boolean abort = false;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private FangvPIDController panelPID;

    private double distance = 0;

    public ControlPanelSpinDistanceCommand(ControlPanelSubsystem controlPanelSubsystem, String color) {
        this.color = color;
        this.controlPanelSubsystem = controlPanelSubsystem;
        this.subsystems = Set.of(controlPanelSubsystem);
        panelPID = new FangvPIDController(100, -100, Constants.CONTROL_PANEL_PID_P,
                Constants.CONTROL_PANEL_PID_I, Constants.CONTROL_PANEL_PID_D, 0);
        colors = new HashMap<String, Map<String, Double>>();
        colors.put("R", new HashMap<>());
        colors.get("R").put("B", 0.0);
        colors.get("R").put("R", 2.0);
        colors.get("R").put("Y", 3.0);
        colors.get("R").put("G", 1.0);

        colors.put("G", new HashMap<>());
        colors.get("G").put("B", 1.0);
        colors.get("G").put("R", 3.0);
        colors.get("G").put("Y", 0.0);
        colors.get("G").put("G", 2.0);

        colors.put("B", new HashMap<>());
        colors.get("B").put("B", 2.0);
        colors.get("B").put("R", 0.0);
        colors.get("B").put("Y", 1.0);
        colors.get("B").put("G", 3.0);

        colors.put("Y", new HashMap<>());
        colors.get("Y").put("B", 3.0);
        colors.get("Y").put("R", 1.0);
        colors.get("Y").put("Y", 2.0);
        colors.get("Y").put("G", 0.0);
    }

    @Override
    public void initialize() {

        String fieldColor = DriverStation.getInstance().getGameSpecificMessage();

        if(fieldColor.isEmpty())
            abort = true;

        distance = colors.get(color).get(fieldColor)
                * Constants.ARC_LENGTH * Constants.TICKS_PER_CENTIMETER;
    }

    @Override
    public void execute() {
        controlPanelSubsystem.Set(panelPID.process(distance, controlPanelSubsystem.getPos()));
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        if ((distance < controlPanelSubsystem.getPos()) || abort)
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
