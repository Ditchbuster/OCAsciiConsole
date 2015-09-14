package org.ditchbuster.ocasciiconsole;

import asciiPanel.AsciiPanel;

/**
 * Created by CPearson on 9/13/2015.
 */
public class RobotFactory {
    private World world;

    public RobotFactory(World world){
        this.world = world;
    }

    public Robot newRobot(){//TODO add the robot in properly
        Robot robot = new Robot(world,'@', AsciiPanel.white);
        world.addAt(robot,1,1);
        //new RobotAi(robot);
        return robot;
    }
}
