package com.ning.arecibo.alert.confdata.objects;

import java.util.Map;

import com.ning.arecibo.util.Logger;

public class ConfDataManagingKeyMapping extends ConfDataObject
{
    private final static Logger log = Logger.getLogger(ConfDataManagingKeyMapping.class);

    public final static String TYPE_NAME = "managing_key_mapping";
    public final static String INSERT_TEMPLATE_NAME = ":insert_managing_key_mapping";
    public final static String UPDATE_TEMPLATE_NAME = ":update_managing_key_mapping";

    private final static String ALERTING_CONFIG_ID_FIELD = "alerting_config_id";
    private final static String MANAGING_KEY_ID_FIELD = "managing_key_id";

    protected volatile Long alertingConfigId = null;
    protected volatile Long managingKeyId = null;

    public ConfDataManagingKeyMapping() {}

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
        setAlertingConfigId(getLong(map, ALERTING_CONFIG_ID_FIELD));
        setManagingKeyId(getLong(map, MANAGING_KEY_ID_FIELD));
    }

    @Override
    public Map<String,Object> toPropertiesMap() {
        Map<String,Object> map = super.toPropertiesMap();
        setLong(map, ALERTING_CONFIG_ID_FIELD, getAlertingConfigId());
        setLong(map, MANAGING_KEY_ID_FIELD, getManagingKeyId());

        return map;
    }

    @Override
    public void toStringBuilder(StringBuilder sb) {
        super.toStringBuilder(sb);
        sb.append(String.format("   %s -> %s\n",ALERTING_CONFIG_ID_FIELD,getAlertingConfigId()));
        sb.append(String.format("   %s -> %s\n", MANAGING_KEY_ID_FIELD, getManagingKeyId()));
    }

    public Long getAlertingConfigId() {
        return alertingConfigId;
    }

    public void setAlertingConfigId(Long alertingConfigId) {
        this.alertingConfigId = alertingConfigId;
    }

    public Long getManagingKeyId() {
        return managingKeyId;
    }

    public void setManagingKeyId(Long managingKeyId) {
        this.managingKeyId = managingKeyId;
    }
}
