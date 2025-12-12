package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public interface JsonNodeCreator {
    ArrayNode arrayNode();

    ArrayNode arrayNode(int i10);

    ValueNode binaryNode(byte[] bArr);

    ValueNode binaryNode(byte[] bArr, int i10, int i11);

    ValueNode booleanNode(boolean z10);

    ValueNode nullNode();

    ValueNode numberNode(byte b10);

    ValueNode numberNode(double d10);

    ValueNode numberNode(float f10);

    ValueNode numberNode(int i10);

    ValueNode numberNode(long j10);

    ValueNode numberNode(Byte b10);

    ValueNode numberNode(Double d10);

    ValueNode numberNode(Float f10);

    ValueNode numberNode(Integer num);

    ValueNode numberNode(Long l10);

    ValueNode numberNode(Short sh2);

    ValueNode numberNode(BigDecimal bigDecimal);

    ValueNode numberNode(BigInteger bigInteger);

    ValueNode numberNode(short s10);

    ObjectNode objectNode();

    ValueNode pojoNode(Object obj);

    ValueNode rawValueNode(RawValue rawValue);

    ValueNode textNode(String str);
}
