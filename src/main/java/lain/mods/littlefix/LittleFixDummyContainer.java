package lain.mods.littlefix;

import java.util.Arrays;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

public class LittleFixDummyContainer extends DummyModContainer
{

    public LittleFixDummyContainer()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "LittleFix";
        meta.name = "LittleFix";
        meta.version = "1.7.2-v1";
        meta.authorList = Arrays.asList("zlainsama");
        meta.description = "";
        meta.credits = "";
        meta.url = "https://github.com/zlainsama/littlefix";
        meta.updateUrl = "https://github.com/zlainsama/littlefix/releases";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        return true;
    }

}
