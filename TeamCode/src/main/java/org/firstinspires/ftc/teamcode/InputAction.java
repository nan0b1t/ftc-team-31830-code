package org.firstinspires.ftc.teamcode;

public class InputAction {
    public InputHandler.Button input;
    public InputHandler.GamepadNum gamepad;
    public InputType inputType;

    public enum InputType {
        IS_PRESSED,
        WAS_PRESSED,
        WAS_RELEASED
    }
}
