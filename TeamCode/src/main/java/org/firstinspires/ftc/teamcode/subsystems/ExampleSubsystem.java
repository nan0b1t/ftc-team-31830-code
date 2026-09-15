package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.Subsystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ExampleSubsystem implements Subsystem {
    public String getName() {
        return "Example Subsystem";
    }

    public void init(Telemetry telemetry) {
        telemetry.addLine("Initalizing example subsystem...");
    }

    public void update(Telemetry telemetry) {

    }

    public void terminate(Telemetry telemetry) {
        telemetry.addLine("Upadting example subsystem...");

    }
}
