package com.ning.arecibo.alert.confdata.objects;

import java.util.Map;

import com.ning.arecibo.util.Logger;

public class ConfDataThresholdContextAttr extends ConfDataObject
{
    private final static Logger log = Logger.getLogger(ConfDataThresholdContextAttr.class);

    public final static String TYPE_NAME = "threshold_context_attr";
    public final static String INSERT_TEMPLATE_NAME = ":insert_threshold_context_attr";
    public final static String UPDATE_TEMPLATE_NAME = ":update_threshold_context_attr";

    private final static String THRESHOLD_CONFIG_ID_FIELD = "threshold_config_id";
    private final static String ATTRIBUTE_TYPE_FIELD = "attribute_type";

    protected volatile Long thresholdConfigId = null;
    protected volatile String attributeType = null;

    public ConfDataThresholdContextAttr() {}

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public String getInsertSqlTemplateName() {
        return INSERT_TEMPLATE_NAME;
    }

    @Override
    public String getUpdateSqlTemplateName() {
        return UPDATE_TEMPLATE_NAME;
    }

    @Override
    public void setPropertiesFromMap(Map<String,Object> map) {
        super.setPropertiesFromMap(map);
        setThresholdConfigId(getLong(map,THRESHOLD_CONFIG_ID_FIELD));
        setAttributeType(getString(map,ATTRIBUTE_TYPE_FIELD));
    }

    @Override
    public Map<String,Object> toPropertiesMap() {
        Map<String,Object> map = super.toPropertiesMap();
        setLong(map, THRESHOLD_CONFIG_ID_FIELD,getThresholdConfigId());
        setString(map,ATTRIBUTE_TYPE_FIELD,getAttributeType());

        return map;
    }

    @Override
    public void toStringBuilder(StringBuilder sb) {
        super.toStringBuilder(sb);
        sb.append(String.format("   %s -> %s\n",THRESHOLD_CONFIG_ID_FIELD,getThresholdConfigId()));
        sb.append(String.format("   %s -> %s\n",ATTRIBUTE_TYPE_FIELD,getAttributeType()));
    }

    public Long getThresholdConfigId() {
        return thresholdConfigId;
    }

    public void setThresholdConfigId(Long thresholdConfigId) {
        this.thresholdConfigId = thresholdConfigId;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }
}
