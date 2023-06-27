package Graphic.Vilgax;

import Graphic.ObjectsInGame;
import Model.MyProjectData;
import Model.Vilgax.*;
import Model.VilgaxAndScreenConnection;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vilgax extends ObjectsInGame {

    public VilgaxAndScreenConnection vilgaxAndScreenConnection;
    private BufferedImage activeBackground;
    private final BufferedImage Vilgax_Phase1;
    private final BufferedImage Vilgax_Phase1_Jump_Attack;
    private final BufferedImage Vilgax_Phase1_Filliped;
    private final BufferedImage Vilgax_Phase1_Filliped_Jump_Attack;
    private final BufferedImage Vilgax_Phase2;
    private final BufferedImage Vilgax_Phase2_Jump_Attack;
    private final BufferedImage Vilgax_Phase2_Filliped;
    private final BufferedImage Vilgax_Phase2_Filliped_Jump_Attack;
    private final BufferedImage Vilgax_Grab;
    private final BufferedImage Vilgax_Grab_Filliped;

    public VilgaxMove activeMove;
    public VilgaxMove vilgaxDoNothing;
    public VilgaxMove vilgaxFireBallAttack;
    public VilgaxMove vilgaxGrabAttack;
    public VilgaxMove vilgaxNukeAttack;
    public VilgaxMove vilgaxJumpAttack;
    public VilgaxMove vilgaxRun;
    public VilgaxMove vilgaxJump;

    private int x;
    private int y;
    private int width = 150;
    private int height = 240;
    private double XVelocity = -3;// Run: -3
    private double YVelocity = -5;
    private boolean isVilgaxPhase_2 =true;

    public Vilgax(int x, int y) {

        this.setSize(width, height);
        this.x = x;
        this.y = y;

        vilgaxDoNothing = new VilgaxDoNothing(this);
        vilgaxJump = new VilgaxJump(this);
        vilgaxRun = new VilgaxRun(this);
        vilgaxFireBallAttack = new VilgaxFireBallAttack(this);
        vilgaxGrabAttack = new VilgaxGrabAttack(this);
        vilgaxNukeAttack = new VilgaxNukeAttack(this);
        vilgaxJumpAttack = new VilgaxJumpAttack(this);
        activeMove = vilgaxJump;

        Vilgax_Phase1 = MyProjectData.getProjectData().getVilgax_Phase1();
        Vilgax_Phase1_Jump_Attack = MyProjectData.getProjectData().getVilgax_Phase1_Jump_Attack();
        Vilgax_Phase1_Filliped = MyProjectData.getProjectData().getVilgax_Phase1_Filliped();
        Vilgax_Phase1_Filliped_Jump_Attack = MyProjectData.getProjectData().getVilgax_Phase1_Filliped_Jump_Attack();

        Vilgax_Phase2 = MyProjectData.getProjectData().getVilgax_Phase2();
        Vilgax_Phase2_Jump_Attack = MyProjectData.getProjectData().getVilgax_Phase2_Jump_Attack();
        Vilgax_Phase2_Filliped = MyProjectData.getProjectData().getVilgax_Phase2_Filliped();
        Vilgax_Phase2_Filliped_Jump_Attack = MyProjectData.getProjectData().getVilgax_Phase2_Filliped_Jump_Attack();

        Vilgax_Grab = MyProjectData.getProjectData().getVilgax_Grab();
        Vilgax_Grab_Filliped = MyProjectData.getProjectData().getVilgax_Grab_Filliped();

        activeBackground = Vilgax_Phase1;

    }

    public void addConnection(VilgaxAndScreenConnection vilgaxAndScreenConnection) {
        this.vilgaxAndScreenConnection = vilgaxAndScreenConnection;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(activeBackground, 0, 0, 150, 240, null);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public double getXVelocity() {
        return XVelocity;
    }

    public void setXVelocity(double XVelocity) {
        this.XVelocity = XVelocity;
    }

    public BufferedImage getActiveBackground() {
        return activeBackground;
    }

    public void setActiveBackground(BufferedImage activeBackground) {
        this.activeBackground = activeBackground;
    }

    public BufferedImage getVilgax_Phase1() {
        return Vilgax_Phase1;
    }

    public BufferedImage getVilgax_Phase1_Jump_Attack() {
        return Vilgax_Phase1_Jump_Attack;
    }

    public BufferedImage getVilgax_Phase1_Filliped() {
        return Vilgax_Phase1_Filliped;
    }

    public BufferedImage getVilgax_Phase1_Filliped_Jump_Attack() {
        return Vilgax_Phase1_Filliped_Jump_Attack;
    }

    public BufferedImage getVilgax_Phase2() {
        return Vilgax_Phase2;
    }

    public BufferedImage getVilgax_Phase2_Jump_Attack() {
        return Vilgax_Phase2_Jump_Attack;
    }

    public BufferedImage getVilgax_Phase2_Filliped() {
        return Vilgax_Phase2_Filliped;
    }

    public BufferedImage getVilgax_Phase2_Filliped_Jump_Attack() {
        return Vilgax_Phase2_Filliped_Jump_Attack;
    }

    public BufferedImage getVilgax_Grab() {
        return Vilgax_Grab;
    }

    public BufferedImage getVilgax_Grab_Filliped() {
        return Vilgax_Grab_Filliped;
    }

    public double getYVelocity() {
        return YVelocity;
    }

    public void setYVelocity(double YVelocity) {
        this.YVelocity = YVelocity;
    }

    public boolean isVilgaxPhase_2() {
        return isVilgaxPhase_2;
    }

    public void setVilgaxPhase_2(boolean vilgaxPhase_2) {
        isVilgaxPhase_2 = vilgaxPhase_2;
    }
}
