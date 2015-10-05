package org.codelibs.fess.es.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.codelibs.fess.es.exentity.SuggestElevateWord;
import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.ColumnInfo;
import org.dbflute.dbmeta.info.UniqueInfo;
import org.dbflute.dbmeta.name.TableSqlName;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import org.dbflute.util.DfTypeUtil;

public class SuggestElevateWordDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SuggestElevateWordDbm _instance = new SuggestElevateWordDbm();

    private SuggestElevateWordDbm() {
    }

    public static SuggestElevateWordDbm getInstance() {
        return _instance;
    }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getBoost(),
                (et, vl) -> ((SuggestElevateWord) et).setBoost(DfTypeUtil.toFloat(vl)), "boost");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getCreatedBy(),
                (et, vl) -> ((SuggestElevateWord) et).setCreatedBy(DfTypeUtil.toString(vl)), "createdBy");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getCreatedTime(),
                (et, vl) -> ((SuggestElevateWord) et).setCreatedTime(DfTypeUtil.toLong(vl)), "createdTime");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getId(), (et, vl) -> ((SuggestElevateWord) et).setId(DfTypeUtil.toString(vl)),
                "id");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getReading(),
                (et, vl) -> ((SuggestElevateWord) et).setReading(DfTypeUtil.toString(vl)), "reading");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getSuggestWord(),
                (et, vl) -> ((SuggestElevateWord) et).setSuggestWord(DfTypeUtil.toString(vl)), "suggestWord");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getTargetLabel(),
                (et, vl) -> ((SuggestElevateWord) et).setTargetLabel(DfTypeUtil.toString(vl)), "targetLabel");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getTargetRole(),
                (et, vl) -> ((SuggestElevateWord) et).setTargetRole(DfTypeUtil.toString(vl)), "targetRole");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getUpdatedBy(),
                (et, vl) -> ((SuggestElevateWord) et).setUpdatedBy(DfTypeUtil.toString(vl)), "updatedBy");
        setupEpg(_epgMap, et -> ((SuggestElevateWord) et).getUpdatedTime(),
                (et, vl) -> ((SuggestElevateWord) et).setUpdatedTime(DfTypeUtil.toLong(vl)), "updatedTime");
    }

    @Override
    public PropertyGateway findPropertyGateway(final String prop) {
        return doFindEpg(_epgMap, prop);
    }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnBoost = cci("boost", "boost", null, null, Float.class, "boost", null, false, false, false, "Float",
            0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCreatedBy = cci("createdBy", "createdBy", null, null, String.class, "createdBy", null, false, false,
            false, "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCreatedTime = cci("createdTime", "createdTime", null, null, Long.class, "createdTime", null, false,
            false, false, "Long", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnId = cci("id", "id", null, null, String.class, "id", null, false, false, false, "String", 0, 0, null,
            false, null, null, null, null, null, false);
    protected final ColumnInfo _columnReading = cci("reading", "reading", null, null, String.class, "reading", null, false, false, false,
            "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnSuggestWord = cci("suggestWord", "suggestWord", null, null, String.class, "suggestWord", null, false,
            false, false, "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTargetLabel = cci("targetLabel", "targetLabel", null, null, String.class, "targetLabel", null, false,
            false, false, "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTargetRole = cci("targetRole", "targetRole", null, null, String.class, "targetRole", null, false,
            false, false, "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdatedBy = cci("updatedBy", "updatedBy", null, null, String.class, "updatedBy", null, false, false,
            false, "String", 0, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdatedTime = cci("updatedTime", "updatedTime", null, null, Long.class, "updatedTime", null, false,
            false, false, "Long", 0, 0, null, false, null, null, null, null, null, false);

    public ColumnInfo columnBoost() {
        return _columnBoost;
    }

    public ColumnInfo columnCreatedBy() {
        return _columnCreatedBy;
    }

    public ColumnInfo columnCreatedTime() {
        return _columnCreatedTime;
    }

    public ColumnInfo columnId() {
        return _columnId;
    }

    public ColumnInfo columnReading() {
        return _columnReading;
    }

    public ColumnInfo columnSuggestWord() {
        return _columnSuggestWord;
    }

    public ColumnInfo columnTargetLabel() {
        return _columnTargetLabel;
    }

    public ColumnInfo columnTargetRole() {
        return _columnTargetRole;
    }

    public ColumnInfo columnUpdatedBy() {
        return _columnUpdatedBy;
    }

    public ColumnInfo columnUpdatedTime() {
        return _columnUpdatedTime;
    }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnBoost());
        ls.add(columnCreatedBy());
        ls.add(columnCreatedTime());
        ls.add(columnId());
        ls.add(columnReading());
        ls.add(columnSuggestWord());
        ls.add(columnTargetLabel());
        ls.add(columnTargetRole());
        ls.add(columnUpdatedBy());
        ls.add(columnUpdatedTime());
        return ls;
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "suggest_elevate_word";
    protected final String _tableDispName = "suggest_elevate_word";
    protected final String _tablePropertyName = "SuggestElevateWord";

    public String getTableDbName() {
        return _tableDbName;
    }

    @Override
    public String getTableDispName() {
        return _tableDispName;
    }

    @Override
    public String getTablePropertyName() {
        return _tablePropertyName;
    }

    @Override
    public TableSqlName getTableSqlName() {
        return null;
    }

    @Override
    public String getProjectName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getProjectPrefix() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getGenerationGapBasePrefix() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DBDef getCurrentDBDef() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPrimaryKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasCompoundPrimaryKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getEntityTypeName() {
        return "org.codelibs.fess.es.exentity.SuggestElevateWord";
    }

    @Override
    public String getConditionBeanTypeName() {
        return "org.codelibs.fess.es.cbean.SuggestElevateWordCB";
    }

    @Override
    public String getBehaviorTypeName() {
        return "org.codelibs.fess.es.exbhv.SuggestElevateWordBhv";
    }

    @Override
    public Class<? extends Entity> getEntityType() {
        return SuggestElevateWord.class;
    }

    @Override
    public Entity newEntity() {
        return new SuggestElevateWord();
    }

    @Override
    public void acceptPrimaryKeyMap(Entity entity, Map<String, ? extends Object> primaryKeyMap) {
        // TODO Auto-generated method stub

    }

    @Override
    public void acceptAllColumnMap(Entity entity, Map<String, ? extends Object> allColumnMap) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, Object> extractPrimaryKeyMap(Entity entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> extractAllColumnMap(Entity entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected UniqueInfo cpui() {
        // TODO Auto-generated method stub
        return null;
    }

}
