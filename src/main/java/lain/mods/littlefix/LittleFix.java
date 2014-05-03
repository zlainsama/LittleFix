package lain.mods.littlefix;

import java.util.Map;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("LittleFix")
@IFMLLoadingPlugin.MCVersion("1.7.2")
@IFMLLoadingPlugin.TransformerExclusions("lain.mods.littlefix.")
public class LittleFix implements IFMLLoadingPlugin
{

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] { "lain.mods.littlefix.LittleFixTransformer" };
    }

    @Override
    public String getModContainerClass()
    {
        return "lain.mods.littlefix.LittleFixDummyContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> arg0)
    {
    }

}
