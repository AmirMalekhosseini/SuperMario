package Model.Game;

import Controller.Game.ScreenController;
import Controller.Game.VilgaxAndMarioConnection;
import Controller.Game.VilgaxAndScreenConnection;
import View.Game.BossFightSectionScreen;
import Controller.Vilgax.*;

public class BossFightSectionModel extends NormalScreenModel {

    BossFightSectionScreen screen;
    public VilgaxAndScreenConnection vilgaxAndScreenConnection;
    public VilgaxAndMarioConnection vilgaxAndMarioConnection;
    public VilgaxTrigger vilgaxTrigger;
    public VilgaxMover vilgaxMover;
    protected VilgaxMove[] vilgaxMoves = new VilgaxMove[7];
    public VilgaxMove vilgaxDoNothing;
    public VilgaxMove vilgaxFireBallAttack;
    public VilgaxMove vilgaxGrabAttack;
    public VilgaxMove vilgaxNukeAttack;
    public VilgaxMove vilgaxJumpAttack;
    public VilgaxMove vilgaxRun;
    public VilgaxMove vilgaxJump;

    public BossFightSectionModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInBossSection;
        screen = godFather.getBossFightScreenSection();
        createVilgaxMoves(godFather, screen);
        screen.vilgax.addVilgaxMoves(vilgaxMoves);
        vilgaxMover = new VilgaxMover(godFather.gameTimer, screen.vilgax, screen.activeMario, vilgaxMoves);
        vilgaxAndScreenConnection = new VilgaxAndScreenConnection(screen);
        vilgaxAndMarioConnection = new VilgaxAndMarioConnection(screen);
        vilgaxTrigger = new VilgaxTrigger(screen, godFather.getMusicPlayer(),godFather.activeLevel.getLevelPanel());
        screen.vilgax.addConnection(vilgaxAndScreenConnection, vilgaxAndMarioConnection);
        addController();

    }

    private void createVilgaxMoves(GameGodFather godFather, BossFightSectionScreen screen) {

        vilgaxDoNothing = new VilgaxDoNothing(godFather, screen.vilgax);
        vilgaxJump = new VilgaxJump(godFather, screen.vilgax);
        vilgaxRun = new VilgaxRun(godFather, screen.vilgax);
        vilgaxFireBallAttack = new VilgaxFireBallAttack(godFather, screen.vilgax);
        vilgaxGrabAttack = new VilgaxGrabAttack(godFather, screen.vilgax);
        vilgaxNukeAttack = new VilgaxNukeAttack(godFather, screen.vilgax);
        vilgaxJumpAttack = new VilgaxJumpAttack(godFather, screen.vilgax);
        vilgaxMoves[0] = vilgaxDoNothing;
        vilgaxMoves[1] = vilgaxFireBallAttack;
        vilgaxMoves[2] = vilgaxGrabAttack;
        vilgaxMoves[3] = vilgaxJump;
        vilgaxMoves[4] = vilgaxJumpAttack;
        vilgaxMoves[5] = vilgaxNukeAttack;
        vilgaxMoves[6] = vilgaxRun;
        screen.vilgax.activeMove = vilgaxFireBallAttack;


    }

    private void addController() {
        controller = new ScreenController(godFather, screen, intersect, marioMoverController) {
            @Override
            public void gravityStarter() {
                super.gravityStarter();
            }

            @Override
            public void moveItem() {
                super.moveItem();
            }

            @Override
            public void moveEnemy() {
                super.moveEnemy();
            }

            @Override
            public void checkAddShield() {
                super.checkAddShield();
            }

            @Override
            public void checkRemoveShield() {
                super.checkRemoveShield();
            }

            @Override
            public void moveShot() {
                super.moveShot();
            }

            @Override
            public void startThrowSword() {
                super.startThrowSword();
            }

            @Override
            public void setLocationAfterLoose() {
                super.setLocationAfterLoose();
                vilgaxTrigger.shutDownBoss();
            }

        };
    }

    @Override
    public void goToHiddenSection() {

    }

    @Override
    public void goToNextSection() {

        godFather.getGameData().isGameFinish = true;

    }
}
