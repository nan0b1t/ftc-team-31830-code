package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SubsystemManager {
    private ArrayList<Subsystem> subsystems = new ArrayList<>();
    private Telemetry telemetry;
    private InputHandler inputHandler;
    private Robot robot;

    public SubsystemManager(ArrayList<Subsystem> subsystems, Telemetry t, InputHandler inputHandler, Robot robot) {
        this.subsystems = subsystems;
        this.inputHandler = inputHandler;
        this.robot = robot;
        this.telemetry = t;
    }

    public void initSubsystems() {
        for (Subsystem s : subsystems) {
            s.init(telemetry, robot, inputHandler);
        }
    }

    public void updateSubsystems() {
        for (Subsystem s : subsystems) {
            s.update(telemetry, robot, inputHandler);
        }
    }

    public void terminateSubsystems() {
        for (Subsystem s : subsystems) {
            s.terminate(telemetry, robot, inputHandler);
        }
    }
}
