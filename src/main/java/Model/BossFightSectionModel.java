package Model;

import Graphic.BossFightSectionScreen;
import Model.Vilgax.VilgaxMove;
import Model.Vilgax.VilgaxMover;

public class BossFightSectionModel extends ScreenModel {

    public VilgaxAndScreenConnection vilgaxAndScreenConnection;
    public VilgaxAndMarioConnection vilgaxAndMarioConnection;
    public VilgaxMover vilgaxMover;
    protected VilgaxMove[] vilgaxMoves = new VilgaxMove[7];

    public BossFightSectionModel(BossFightSectionScreen screen, IntersectInBossSection intersect, MarioMoverModel marioMoverModel) {

        this.screen = screen;
        this.intersect = intersect;
        this.marioMoverModel = marioMoverModel;
        vilgaxMover = new VilgaxMover(screen.vilgax, screen.activeMario, screen.vilgax.vilgaxMoves);
        vilgaxAndScreenConnection = new VilgaxAndScreenConnection(screen);
        vilgaxAndMarioConnection = new VilgaxAndMarioConnection(screen);
        screen.vilgax.addConnection(vilgaxAndScreenConnection, vilgaxAndMarioConnection);
        addController();

    }

    private void addController() {
        controller=new ScreenController(screen, intersect, marioMoverModel) {
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
            }

            @Override
            public int getSwordCoolDownCounter() {
                return super.getSwordCoolDownCounter();
            }

            @Override
            public void setSwordCoolDownCounter(int swordCoolDownCounter) {
                super.setSwordCoolDownCounter(swordCoolDownCounter);
            }
        };
    }

}
