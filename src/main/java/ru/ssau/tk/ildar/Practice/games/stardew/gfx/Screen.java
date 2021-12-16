package ru.ssau.tk.ildar.Practice.games.stardew.gfx;

public class Screen {
    public static final int MAP_WIDTH=64;
    public static final int MAP_WIDTH_MASK=MAP_WIDTH-1;

    public int[] tiles = new int[MAP_WIDTH*MAP_WIDTH_MASK];
    public int[] colours = new int[MAP_WIDTH*MAP_WIDTH_MASK*4];

    public int[] pixels;

    public static final byte BIT_MIRROR_X = 0x01;
    public static final byte BIT_MIRROR_Y = 0x02;

    public int xOffset=0;
    public int yOffset =0;

    public int width;
    public int height;

    public SpriteSheet sheet;

    public Screen(int width,int height,SpriteSheet sheet){
        this.width=width;
        this.height=height;
        this.sheet=sheet;

        for (int i=0;i<MAP_WIDTH*MAP_WIDTH_MASK;i++){
            colours[i * 4]=0xff00ff; // Розовый цвет(background)
            colours[i*4+1]=0x00ffff;
            colours[i*4+2]=0xffff00;
            colours[i*4+3]=0xffffff;
        }
    }

    public void render() {

    }
}
