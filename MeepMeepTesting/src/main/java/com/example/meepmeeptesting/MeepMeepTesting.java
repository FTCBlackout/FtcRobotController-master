package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(500);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 15, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-35, -65, Math.toRadians(0)))
                .lineToY(-35)
                .waitSeconds(1)
                .lineToY(-65)
                .waitSeconds(0.001)
                .strafeTo(new Vector2d(40,-60))
                .waitSeconds(0.001)
                .splineTo(new Vector2d(45,-35), Math.toRadians(180))
                .waitSeconds(2)
                .strafeTo(new Vector2d(45,-10))
                .waitSeconds(.001)
                .lineToX(-55)
                .waitSeconds(1)
                .strafeTo(new Vector2d(-55,-20))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-55,-10))
                .waitSeconds(.001)
                .lineToX(45)
                .waitSeconds(.001)
                .strafeTo(new Vector2d(45,-35))
                .waitSeconds(1)
                .strafeTo(new Vector2d(45,-10))
                .waitSeconds(0.001)
                .lineToX(-55)
                .waitSeconds(1)
                .strafeTo(new Vector2d(-55,-20))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-55,-10))
                .waitSeconds(.001)
                .lineToX(45)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}