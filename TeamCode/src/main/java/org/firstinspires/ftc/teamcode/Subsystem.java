package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Subsystem
 */
public interface Subsystem {
    String getName();

    void init(Telemetry telemetry);
    void update(Telemetry telemetry);
    void terminate(Telemetry telemetry);
}

