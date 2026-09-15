package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SubsystemManager {
    private ArrayList<Subsystem> subsystems = new ArrayList<>();
    private Telemetry telemetry;

    public SubsystemManager(ArrayList<Subsystem> subsystems, Telemetry t) {
        this.subsystems = subsystems;
        this.telemetry = t;
    }

    public void initSubsystems() {
        for (Subsystem s : subsystems) {
            s.init(telemetry);
        }
    }

    public void updateSubsystems() {
        for (Subsystem s : subsystems) {
            s.update(telemetry);
        }
    }

    public void terminateSubsystems() {
        for (Subsystem s : subsystems) {
            s.terminate(telemetry);
        }
    }
}
