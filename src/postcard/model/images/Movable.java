package postcard.model.images;

public interface Movable {
    void moveByX(int toMove);
    void moveByY(int toMove);
    void moveTo(int x, int y);
}
