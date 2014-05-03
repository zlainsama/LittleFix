package lain.mods.littlefix;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

public class RenderBlocksFix
{

    public static void renderFaceXPos(RenderBlocks render, Block p_147764_1_, double p_147764_2_, double p_147764_4_, double p_147764_6_, IIcon p_147764_8_)
    {
        Tessellator tessellator = Tessellator.instance;

        if (render.hasOverrideBlockTexture())
        {
            p_147764_8_ = render.overrideBlockTexture;
        }

        // double d3 = p_147764_8_.getInterpolatedU(render.renderMaxZ * 16.0D);
        // double d4 = p_147764_8_.getInterpolatedU(render.renderMinZ * 16.0D);
        double d3 = p_147764_8_.getInterpolatedU(render.renderMinZ * 16.0D);
        double d4 = p_147764_8_.getInterpolatedU(render.renderMaxZ * 16.0D);
        double d5 = p_147764_8_.getInterpolatedV(16.0D - render.renderMaxY * 16.0D);
        double d6 = p_147764_8_.getInterpolatedV(16.0D - render.renderMinY * 16.0D);

        if (render.flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if ((render.renderMinZ < 0.0D) || (render.renderMaxZ > 1.0D))
        {
            d3 = p_147764_8_.getMinU();
            d4 = p_147764_8_.getMaxU();
        }

        if ((render.renderMinY < 0.0D) || (render.renderMaxY > 1.0D))
        {
            d5 = p_147764_8_.getMinV();
            d6 = p_147764_8_.getMaxV();
        }

        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (render.uvRotateSouth == 2)
        {
            d3 = p_147764_8_.getInterpolatedU(render.renderMinY * 16.0D);
            d5 = p_147764_8_.getInterpolatedV(16.0D - render.renderMinZ * 16.0D);
            d4 = p_147764_8_.getInterpolatedU(render.renderMaxY * 16.0D);
            d6 = p_147764_8_.getInterpolatedV(16.0D - render.renderMaxZ * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (render.uvRotateSouth == 1)
        {
            d3 = p_147764_8_.getInterpolatedU(16.0D - render.renderMaxY * 16.0D);
            d5 = p_147764_8_.getInterpolatedV(render.renderMaxZ * 16.0D);
            d4 = p_147764_8_.getInterpolatedU(16.0D - render.renderMinY * 16.0D);
            d6 = p_147764_8_.getInterpolatedV(render.renderMinZ * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (render.uvRotateSouth == 3)
        {
            d3 = p_147764_8_.getInterpolatedU(16.0D - render.renderMinZ * 16.0D);
            d4 = p_147764_8_.getInterpolatedU(16.0D - render.renderMaxZ * 16.0D);
            d5 = p_147764_8_.getInterpolatedV(render.renderMaxY * 16.0D);
            d6 = p_147764_8_.getInterpolatedV(render.renderMinY * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_147764_2_ + render.renderMaxX;
        double d12 = p_147764_4_ + render.renderMinY;
        double d13 = p_147764_4_ + render.renderMaxY;
        double d14 = p_147764_6_ + render.renderMinZ;
        double d15 = p_147764_6_ + render.renderMaxZ;

        if (render.renderFromInside)
        {
            d14 = p_147764_6_ + render.renderMaxZ;
            d15 = p_147764_6_ + render.renderMinZ;
        }

        if (render.enableAO)
        {
            tessellator.setColorOpaque_F(render.colorRedTopLeft, render.colorGreenTopLeft, render.colorBlueTopLeft);
            tessellator.setBrightness(render.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d12, d15, d8, d10);
            tessellator.setColorOpaque_F(render.colorRedBottomLeft, render.colorGreenBottomLeft, render.colorBlueBottomLeft);
            tessellator.setBrightness(render.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.setColorOpaque_F(render.colorRedBottomRight, render.colorGreenBottomRight, render.colorBlueBottomRight);
            tessellator.setBrightness(render.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d13, d14, d7, d9);
            tessellator.setColorOpaque_F(render.colorRedTopRight, render.colorGreenTopRight, render.colorBlueTopRight);
            tessellator.setBrightness(render.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        }
        else
        {
            tessellator.addVertexWithUV(d11, d12, d15, d8, d10);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.addVertexWithUV(d11, d13, d14, d7, d9);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        }
    }

    public static void renderFaceZNeg(RenderBlocks render, Block p_147761_1_, double p_147761_2_, double p_147761_4_, double p_147761_6_, IIcon p_147761_8_)
    {
        Tessellator tessellator = Tessellator.instance;

        if (render.hasOverrideBlockTexture())
        {
            p_147761_8_ = render.overrideBlockTexture;
        }

        // double d3 = p_147761_8_.getInterpolatedU(render.renderMaxX * 16.0D);
        // double d4 = p_147761_8_.getInterpolatedU(render.renderMinX * 16.0D);
        double d3 = p_147761_8_.getInterpolatedU(render.renderMinX * 16.0D);
        double d4 = p_147761_8_.getInterpolatedU(render.renderMaxX * 16.0D);
        double d5 = p_147761_8_.getInterpolatedV(16.0D - render.renderMaxY * 16.0D);
        double d6 = p_147761_8_.getInterpolatedV(16.0D - render.renderMinY * 16.0D);

        if (render.flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if ((render.renderMinX < 0.0D) || (render.renderMaxX > 1.0D))
        {
            d3 = p_147761_8_.getMinU();
            d4 = p_147761_8_.getMaxU();
        }

        if ((render.renderMinY < 0.0D) || (render.renderMaxY > 1.0D))
        {
            d5 = p_147761_8_.getMinV();
            d6 = p_147761_8_.getMaxV();
        }

        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (render.uvRotateEast == 2)
        {
            d3 = p_147761_8_.getInterpolatedU(render.renderMinY * 16.0D);
            d5 = p_147761_8_.getInterpolatedV(16.0D - render.renderMinX * 16.0D);
            d4 = p_147761_8_.getInterpolatedU(render.renderMaxY * 16.0D);
            d6 = p_147761_8_.getInterpolatedV(16.0D - render.renderMaxX * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (render.uvRotateEast == 1)
        {
            d3 = p_147761_8_.getInterpolatedU(16.0D - render.renderMaxY * 16.0D);
            d5 = p_147761_8_.getInterpolatedV(render.renderMaxX * 16.0D);
            d4 = p_147761_8_.getInterpolatedU(16.0D - render.renderMinY * 16.0D);
            d6 = p_147761_8_.getInterpolatedV(render.renderMinX * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (render.uvRotateEast == 3)
        {
            d3 = p_147761_8_.getInterpolatedU(16.0D - render.renderMinX * 16.0D);
            d4 = p_147761_8_.getInterpolatedU(16.0D - render.renderMaxX * 16.0D);
            d5 = p_147761_8_.getInterpolatedV(render.renderMaxY * 16.0D);
            d6 = p_147761_8_.getInterpolatedV(render.renderMinY * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_147761_2_ + render.renderMinX;
        double d12 = p_147761_2_ + render.renderMaxX;
        double d13 = p_147761_4_ + render.renderMinY;
        double d14 = p_147761_4_ + render.renderMaxY;
        double d15 = p_147761_6_ + render.renderMinZ;

        if (render.renderFromInside)
        {
            d11 = p_147761_2_ + render.renderMaxX;
            d12 = p_147761_2_ + render.renderMinX;
        }

        if (render.enableAO)
        {
            tessellator.setColorOpaque_F(render.colorRedTopLeft, render.colorGreenTopLeft, render.colorBlueTopLeft);
            tessellator.setBrightness(render.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d14, d15, d7, d9);
            tessellator.setColorOpaque_F(render.colorRedBottomLeft, render.colorGreenBottomLeft, render.colorBlueBottomLeft);
            tessellator.setBrightness(render.brightnessBottomLeft);
            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
            tessellator.setColorOpaque_F(render.colorRedBottomRight, render.colorGreenBottomRight, render.colorBlueBottomRight);
            tessellator.setBrightness(render.brightnessBottomRight);
            tessellator.addVertexWithUV(d12, d13, d15, d8, d10);
            tessellator.setColorOpaque_F(render.colorRedTopRight, render.colorGreenTopRight, render.colorBlueTopRight);
            tessellator.setBrightness(render.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
        }
        else
        {
            tessellator.addVertexWithUV(d11, d14, d15, d7, d9);
            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
            tessellator.addVertexWithUV(d12, d13, d15, d8, d10);
            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
        }
    }

}
