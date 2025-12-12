package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

/* compiled from: JsonNodeDeserializer.java */
/* loaded from: classes.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
    }

    public final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        Object embeddedObject = jsonParser.getEmbeddedObject();
        return embeddedObject == null ? jsonNodeFactory.nullNode() : embeddedObject.getClass() == byte[].class ? jsonNodeFactory.binaryNode((byte[]) embeddedObject) : embeddedObject instanceof RawValue ? jsonNodeFactory.rawValueNode((RawValue) embeddedObject) : embeddedObject instanceof JsonNode ? (JsonNode) embeddedObject : jsonNodeFactory.pojoNode(embeddedObject);
    }

    public final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        return numberType == JsonParser.NumberType.BIG_DECIMAL ? jsonNodeFactory.numberNode(jsonParser.getDecimalValue()) : deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.isNaN() ? jsonNodeFactory.numberNode(jsonParser.getDoubleValue()) : jsonNodeFactory.numberNode(jsonParser.getDecimalValue()) : numberType == JsonParser.NumberType.FLOAT ? jsonNodeFactory.numberNode(jsonParser.getFloatValue()) : jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
    }

    public final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        JsonParser.NumberType numberType = (StdDeserializer.F_MASK_INT_COERCIONS & deserializationFeatures) != 0 ? DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures) ? JsonParser.NumberType.BIG_INTEGER : DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures) ? JsonParser.NumberType.LONG : jsonParser.getNumberType() : jsonParser.getNumberType();
        return numberType == JsonParser.NumberType.INT ? jsonNodeFactory.numberNode(jsonParser.getIntValue()) : numberType == JsonParser.NumberType.LONG ? jsonNodeFactory.numberNode(jsonParser.getLongValue()) : jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    public void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
    }

    public final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId == 2) {
            return jsonNodeFactory.objectNode();
        }
        switch (iCurrentTokenId) {
            case 5:
                return deserializeObjectAtName(jsonParser, deserializationContext, jsonNodeFactory);
            case 6:
                return jsonNodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
            case 9:
                return jsonNodeFactory.booleanNode(true);
            case 10:
                return jsonNodeFactory.booleanNode(false);
            case 11:
                return jsonNodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    public final ArrayNode deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        while (true) {
            switch (jsonParser.nextToken().id()) {
                case 1:
                    arrayNode.add(deserializeObject(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    arrayNode.add(deserializeAny(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 3:
                    arrayNode.add(deserializeArray(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 4:
                    return arrayNode;
                case 6:
                    arrayNode.add(jsonNodeFactory.textNode(jsonParser.getText()));
                    break;
                case 7:
                    arrayNode.add(_fromInt(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 9:
                    arrayNode.add(jsonNodeFactory.booleanNode(true));
                    break;
                case 10:
                    arrayNode.add(jsonNodeFactory.booleanNode(false));
                    break;
                case 11:
                    arrayNode.add(jsonNodeFactory.nullNode());
                    break;
                case 12:
                    arrayNode.add(_fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
            }
        }
    }

    public final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonNode jsonNodeDeserializeObject;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String strNextFieldName = jsonParser.nextFieldName();
        while (strNextFieldName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                jsonNodeDeserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (iId == 3) {
                jsonNodeDeserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (iId == 6) {
                jsonNodeDeserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
            } else if (iId != 7) {
                switch (iId) {
                    case 9:
                        jsonNodeDeserializeObject = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        jsonNodeDeserializeObject = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        jsonNodeDeserializeObject = jsonNodeFactory.nullNode();
                        break;
                    case 12:
                        jsonNodeDeserializeObject = _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    default:
                        jsonNodeDeserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
            } else {
                jsonNodeDeserializeObject = _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            }
            JsonNode jsonNode = jsonNodeDeserializeObject;
            JsonNode jsonNodeReplace = objectNode.replace(strNextFieldName, jsonNode);
            if (jsonNodeReplace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strNextFieldName, objectNode, jsonNodeReplace, jsonNode);
            }
            strNextFieldName = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    public final ObjectNode deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonNode jsonNodeDeserializeObject;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String currentName = jsonParser.getCurrentName();
        while (currentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                jsonNodeDeserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (iId == 3) {
                jsonNodeDeserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (iId == 6) {
                jsonNodeDeserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
            } else if (iId != 7) {
                switch (iId) {
                    case 9:
                        jsonNodeDeserializeObject = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        jsonNodeDeserializeObject = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        jsonNodeDeserializeObject = jsonNodeFactory.nullNode();
                        break;
                    case 12:
                        jsonNodeDeserializeObject = _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    default:
                        jsonNodeDeserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
            } else {
                jsonNodeDeserializeObject = _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            }
            JsonNode jsonNode = jsonNodeDeserializeObject;
            JsonNode jsonNodeReplace = objectNode.replace(currentName, jsonNode);
            if (jsonNodeReplace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, currentName, objectNode, jsonNodeReplace, jsonNode);
            }
            currentName = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    public final JsonNode updateArray(JsonParser jsonParser, DeserializationContext deserializationContext, ArrayNode arrayNode) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        while (true) {
            switch (jsonParser.nextToken().id()) {
                case 1:
                    arrayNode.add(deserializeObject(jsonParser, deserializationContext, nodeFactory));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    arrayNode.add(deserializeAny(jsonParser, deserializationContext, nodeFactory));
                    break;
                case 3:
                    arrayNode.add(deserializeArray(jsonParser, deserializationContext, nodeFactory));
                    break;
                case 4:
                    return arrayNode;
                case 6:
                    arrayNode.add(nodeFactory.textNode(jsonParser.getText()));
                    break;
                case 7:
                    arrayNode.add(_fromInt(jsonParser, deserializationContext, nodeFactory));
                    break;
                case 9:
                    arrayNode.add(nodeFactory.booleanNode(true));
                    break;
                case 10:
                    arrayNode.add(nodeFactory.booleanNode(false));
                    break;
                case 11:
                    arrayNode.add(nodeFactory.nullNode());
                    break;
                case 12:
                    arrayNode.add(_fromEmbedded(jsonParser, deserializationContext, nodeFactory));
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fasterxml.jackson.databind.JsonNode updateObject(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12, com.fasterxml.jackson.databind.node.ObjectNode r13) throws java.io.IOException {
        /*
            r10 = this;
            boolean r0 = r11.isExpectedStartObjectToken()
            if (r0 == 0) goto Lb
            java.lang.String r0 = r11.nextFieldName()
            goto L1e
        Lb:
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            boolean r0 = r11.hasToken(r0)
            if (r0 != 0) goto L1a
            java.lang.Object r11 = r10.deserialize(r11, r12)
            com.fasterxml.jackson.databind.JsonNode r11 = (com.fasterxml.jackson.databind.JsonNode) r11
            return r11
        L1a:
            java.lang.String r0 = r11.getCurrentName()
        L1e:
            if (r0 == 0) goto Laf
            com.fasterxml.jackson.core.JsonToken r1 = r11.nextToken()
            com.fasterxml.jackson.databind.JsonNode r7 = r13.get(r0)
            if (r7 == 0) goto L4e
            boolean r2 = r7 instanceof com.fasterxml.jackson.databind.node.ObjectNode
            if (r2 == 0) goto L3c
            r1 = r7
            com.fasterxml.jackson.databind.node.ObjectNode r1 = (com.fasterxml.jackson.databind.node.ObjectNode) r1
            com.fasterxml.jackson.databind.JsonNode r1 = r10.updateObject(r11, r12, r1)
            if (r1 == r7) goto La9
            r13.set(r0, r1)
            goto La9
        L3c:
            boolean r2 = r7 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            if (r2 == 0) goto L4e
            r1 = r7
            com.fasterxml.jackson.databind.node.ArrayNode r1 = (com.fasterxml.jackson.databind.node.ArrayNode) r1
            com.fasterxml.jackson.databind.JsonNode r1 = r10.updateArray(r11, r12, r1)
            if (r1 == r7) goto La9
            r13.set(r0, r1)
            goto La9
        L4e:
            if (r1 != 0) goto L52
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE
        L52:
            com.fasterxml.jackson.databind.node.JsonNodeFactory r4 = r12.getNodeFactory()
            int r1 = r1.id()
            r2 = 1
            if (r1 == r2) goto L96
            r3 = 3
            if (r1 == r3) goto L91
            r3 = 6
            if (r1 == r3) goto L88
            r3 = 7
            if (r1 == r3) goto L83
            switch(r1) {
                case 9: goto L7e;
                case 10: goto L78;
                case 11: goto L73;
                case 12: goto L6e;
                default: goto L69;
            }
        L69:
            com.fasterxml.jackson.databind.JsonNode r1 = r10.deserializeAny(r11, r12, r4)
            goto L9a
        L6e:
            com.fasterxml.jackson.databind.JsonNode r1 = r10._fromEmbedded(r11, r12, r4)
            goto L9a
        L73:
            com.fasterxml.jackson.databind.node.NullNode r1 = r4.nullNode()
            goto L9a
        L78:
            r1 = 0
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r4.booleanNode(r1)
            goto L9a
        L7e:
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r4.booleanNode(r2)
            goto L9a
        L83:
            com.fasterxml.jackson.databind.JsonNode r1 = r10._fromInt(r11, r12, r4)
            goto L9a
        L88:
            java.lang.String r1 = r11.getText()
            com.fasterxml.jackson.databind.node.TextNode r1 = r4.textNode(r1)
            goto L9a
        L91:
            com.fasterxml.jackson.databind.node.ArrayNode r1 = r10.deserializeArray(r11, r12, r4)
            goto L9a
        L96:
            com.fasterxml.jackson.databind.node.ObjectNode r1 = r10.deserializeObject(r11, r12, r4)
        L9a:
            r9 = r1
            if (r7 == 0) goto La6
            r1 = r10
            r2 = r11
            r3 = r12
            r5 = r0
            r6 = r13
            r8 = r9
            r1._handleDuplicateField(r2, r3, r4, r5, r6, r7, r8)
        La6:
            r13.set(r0, r9)
        La9:
            java.lang.String r0 = r11.nextFieldName()
            goto L1e
        Laf:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.updateObject(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.node.ObjectNode):com.fasterxml.jackson.databind.JsonNode");
    }
}
