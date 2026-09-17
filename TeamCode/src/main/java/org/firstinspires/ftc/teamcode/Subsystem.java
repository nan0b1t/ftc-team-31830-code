package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Subsystem
 */
public interface Subsystem {
    String getName();

    void init(Telemetry telemetry, Robot robot, InputHandler iHandler);
    void update(Telemetry telemetry, Robot robot, InputHandler iHandler);
    void terminate(Telemetry telemetry, Robot robot, InputHandler iHandler);
}

