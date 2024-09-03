package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RR.MecanumDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;

@Autonomous
public final class FSMTest extends LinearOpMode {
    private enum State{
        STATE_INITIAL,
        STATE_DRIVETOLINE,
        STATE_PLACEPIXEL,

    }
    @Override

    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(-35, -65, Math.toRadians(90));
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .lineToY(-35)
                            .waitSeconds(1)
                            .lineToY(-65)
                            .turn(Math.toRadians(90))
                            .lineToX(35)
                            .splineTo(new Vector2d(45,-35), Math.toRadians(0))
                            .waitSeconds(2)
                            .strafeTo(new Vector2d(45,-65))
                            .waitSeconds(.1)
                            .lineToX(55)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}
