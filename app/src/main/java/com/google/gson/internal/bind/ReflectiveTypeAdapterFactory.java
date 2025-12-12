package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v9.l;
import v9.u;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements x {

    /* renamed from: b, reason: collision with root package name */
    public final l f10124b;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.gson.c f10125m;

    /* renamed from: n, reason: collision with root package name */
    public final Excluder f10126n;

    /* renamed from: o, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f10127o;

    /* renamed from: p, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f10128p;

    public static final class a<T> extends w<T> {

        /* renamed from: a, reason: collision with root package name */
        public final u<T> f10129a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, b> f10130b;

        public a(u uVar, LinkedHashMap linkedHashMap) {
            this.f10129a = uVar;
            this.f10130b = linkedHashMap;
        }

        @Override // com.google.gson.w
        public T read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            T tConstruct = this.f10129a.construct();
            try {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    b bVar = this.f10130b.get(aVar.nextName());
                    if (bVar == null || !bVar.f10133c) {
                        aVar.skipValue();
                    } else {
                        bVar.a(aVar, tConstruct);
                    }
                }
                aVar.endObject();
                return tConstruct;
            } catch (IllegalAccessException e10) {
                throw x9.a.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalStateException e11) {
                throw new JsonSyntaxException(e11);
            }
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, T t10) throws IOException {
            if (t10 == null) {
                bVar.nullValue();
                return;
            }
            bVar.beginObject();
            try {
                Iterator<b> it = this.f10130b.values().iterator();
                while (it.hasNext()) {
                    it.next().b(bVar, t10);
                }
                bVar.endObject();
            } catch (IllegalAccessException e10) {
                throw x9.a.createExceptionForUnexpectedIllegalAccess(e10);
            }
        }
    }

    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f10131a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10132b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10133c;

        public b(String str, boolean z10, boolean z11) {
            this.f10131a = str;
            this.f10132b = z10;
            this.f10133c = z11;
        }

        public abstract void a(z9.a aVar, Object obj) throws IllegalAccessException, IOException;

        public abstract void b(z9.b bVar, Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(l lVar, com.google.gson.c cVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.f10124b = lVar;
        this.f10125m = cVar;
        this.f10126n = excluder;
        this.f10127o = jsonAdapterAnnotationTypeAdapterFactory;
        this.f10128p = list;
    }

    public static void a(Object obj, Field field) {
        if (Modifier.isStatic(field.getModifiers())) {
            obj = null;
        }
        if (v9.x.canAccess(field, obj)) {
            return;
        }
        throw new JsonIOException("Field '" + field.getDeclaringClass().getName() + "#" + field.getName() + "' is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type or adjust the access filter.");
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override // com.google.gson.x
    public <T> com.google.gson.w<T> create(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r41v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */
}
