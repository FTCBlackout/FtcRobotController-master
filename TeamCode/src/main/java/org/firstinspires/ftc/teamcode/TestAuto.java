package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RR.MecanumDrive;
import org.firstinspires.ftc.teamcode.RR.TankDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;
@Autonomous
public final class TestAuto extends LinearOpMode {
    @Override

    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(0, 0, 0);
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .lineToX(60)
                            .lineToX(0)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}
