package mchellspawn.compressedfurnace;

public class reference {

    public static final String MODID = "compressedfurance";
    public static final String MODNAME = "Compressed Furance";
    public static final String VERSION = "1.0";
    
    public static final String CLIENTPROXY = "mchellspawn.compressedfurnace.proxy.ClientProxy";
    public static final String SERVERPROXY = "mchellspawn.compressedfurnace.proxy.ServerProxy";
    
    public static enum compressedFurnaceItems {
    	COMPRESSEDFURNACE("compressedfurnace", "ItemCompressedFurnace");
    	
    	private String unlocalizedName;
    	private String registryName;
    	
    	compressedFurnaceItems (String unlocalizedName, String registryName) {
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;    				
    	}
    	
    	public String getUnlocalizedName() {
			return unlocalizedName;
		}
    	
    	public String getRegistryName() {
			return registryName;
		}
    }
}
