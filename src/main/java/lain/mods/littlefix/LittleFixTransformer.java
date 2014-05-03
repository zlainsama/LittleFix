package lain.mods.littlefix;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

public class LittleFixTransformer implements IClassTransformer
{

    class a extends ClassVisitor
    {

        Map<String, String> names;
        String cl;

        public a(ClassVisitor cv)
        {
            super(Opcodes.ASM4, cv);
            cl = FMLDeobfuscatingRemapper.INSTANCE.unmap("net/minecraft/client/renderer/RenderBlocks");
            names = new HashMap<String, String>();
            names.put("func_147764_f", "renderFaceXPos");
            names.put("renderFaceXPos", "renderFaceXPos");
            names.put("func_147761_c", "renderFaceZNeg");
            names.put("renderFaceZNeg", "renderFaceZNeg");
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
        {
            String targetname = names.get(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(cl, name, desc));
            if (targetname != null/* && "(Lnet/minecraft/block/Block;DDDLnet/minecraft/util/IIcon;)V".equals(signature) */)
            {
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitVarInsn(Opcodes.DLOAD, 2);
                mv.visitVarInsn(Opcodes.DLOAD, 4);
                mv.visitVarInsn(Opcodes.DLOAD, 6);
                mv.visitVarInsn(Opcodes.ALOAD, 8);
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/littlefix/RenderBlocksFix", targetname, "(Lnet/minecraft/client/renderer/RenderBlocks;Lnet/minecraft/block/Block;DDDLnet/minecraft/util/IIcon;)V");
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(1, 1);
                mv.visitEnd();
                return new b();
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }

    }

    class b extends MethodVisitor
    {

        public b()
        {
            super(Opcodes.ASM4, null);
        }

    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if ("net.minecraft.client.renderer.RenderBlocks".equals(transformedName))
            return transform001(bytes);
        return bytes;
    }

    private byte[] transform001(byte[] bytes)
    {
        ClassReader classReader = new ClassReader(bytes);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classReader.accept(new a(classWriter), ClassReader.EXPAND_FRAMES);
        return classWriter.toByteArray();
    }

}
