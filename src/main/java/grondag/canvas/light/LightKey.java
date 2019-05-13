package grondag.canvas.light;

import grondag.fermion.varia.BitPacker64;
import grondag.fermion.varia.BitPacker64.BooleanElement;
import grondag.fermion.varia.BitPacker64.IntElement;

@SuppressWarnings("rawtypes")
public final class LightKey {
    private static final BitPacker64<Void> PACKER = new BitPacker64<Void>(null, null);
    
    private static final IntElement CENTER = PACKER.createIntElement(-1, 60);
    
    private static final IntElement TOP = PACKER.createIntElement(-1, 60);
    private static final IntElement LEFT = PACKER.createIntElement(-1, 60);
    private static final IntElement RIGHT = PACKER.createIntElement(-1, 60);
    private static final IntElement BOTTOM = PACKER.createIntElement(-1, 60);
    
    private static final IntElement TOP_LEFT = PACKER.createIntElement(-1, 60);
    private static final IntElement TOP_RIGHT = PACKER.createIntElement(-1, 60);
    private static final IntElement BOTTOM_LEFT = PACKER.createIntElement(-1, 60);
    private static final IntElement BOTTOM_RIGHT = PACKER.createIntElement(-1, 60);
    
    private static final BooleanElement IS_AO = PACKER.createBooleanElement();
    
    static long toKey240(
            int top,
            int left,
            int right,
            int bottom,
            int topLeft,
            int topRight,
            int bottomLeft,
            int bottomRight,
            int center, 
            boolean isAo)
    {
        long result = CENTER.setValue(clamp240(center), 0);
        
        result = TOP.setValue(clamp240(top), result);
        result = LEFT.setValue(clamp240(left), result);
        result = RIGHT.setValue(clamp240(right), result);
        result = BOTTOM.setValue(clamp240(bottom), result);
        
        result = TOP_LEFT.setValue(clamp240(topLeft), result);
        result = TOP_RIGHT.setValue(clamp240(topRight), result);
        result = BOTTOM_LEFT.setValue(clamp240(bottomLeft), result);
        result = BOTTOM_RIGHT.setValue(clamp240(bottomRight), result);
        
        result = IS_AO.setValue(isAo, result);
        
        return result;
    }
    
    private static int clamp240(int val) {
        if(val < 0 || val == 0xFF) {
            return -1;
        } else if(val > 240) {
            return 60;
        }
        return val >> 2; // 0-60
    }
    
    private static int unclamp240(int val) {
        return val == -1 ? AoFaceData.OPAQUE : val << 2;
    }
    
    public static int center(long key) {
        return unclamp240(CENTER.getValue(key));
    }
    
    public static int top(long key) {
        return unclamp240(TOP.getValue(key));
    }
    
    public static int left(long key) {
        return unclamp240(LEFT.getValue(key));
    }
    
    public static int right(long key) {
        return unclamp240(RIGHT.getValue(key));
    }
    
    public static int bottom(long key) {
        return unclamp240(BOTTOM.getValue(key));
    }
    
    public static int topLeft(long key) {
        return unclamp240(TOP_LEFT.getValue(key));
    }
    
    public static int topRight(long key) {
        return unclamp240(TOP_RIGHT.getValue(key));
    }
    
    public static int bottomLeft(long key) {
        return unclamp240(BOTTOM_LEFT.getValue(key));
    }
    
    public static int bottomRight(long key) {
        return unclamp240(BOTTOM_RIGHT.getValue(key));
    }
    
    public static boolean isAo(long key) {
        return IS_AO.getValue(key);
    }
}