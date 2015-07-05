package org.codelibs.fess.es.bsbhv;

import java.util.Map;

import org.codelibs.fess.es.bsentity.AbstractEntity;
import org.codelibs.fess.es.bsentity.AbstractEntity.RequestOptionCall;
import org.codelibs.fess.es.bsentity.dbmeta.WebConfigDbm;
import org.codelibs.fess.es.cbean.WebConfigCB;
import org.codelibs.fess.es.exentity.WebConfig;
import org.dbflute.Entity;
import org.dbflute.bhv.readable.CBCall;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.cbean.result.PagingResultBean;
import org.dbflute.exception.IllegalBehaviorStateException;
import org.dbflute.optional.OptionalEntity;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;

/**
 * @author FreeGen
 */
public abstract class BsWebConfigBhv extends AbstractBehavior<WebConfig, WebConfigCB> {

    @Override
    public String asTableDbName() {
        return "web_config";
    }

    @Override
    protected String asIndexEsName() {
        return ".fess_config";
    }

    @Override
    public WebConfigDbm asDBMeta() {
        return WebConfigDbm.getInstance();
    }

    @Override
    protected <RESULT extends WebConfig> RESULT createEntity(Map<String, Object> source, Class<? extends RESULT> entityType) {
        try {
            final RESULT result = entityType.newInstance();
            result.setAvailable((Boolean) source.get("available"));
            result.setBoost((Float) source.get("boost"));
            result.setConfigParameter((String) source.get("configParameter"));
            result.setCreatedBy((String) source.get("createdBy"));
            result.setCreatedTime((Long) source.get("createdTime"));
            result.setDepth((Integer) source.get("depth"));
            result.setExcludedDocUrls((String) source.get("excludedDocUrls"));
            result.setExcludedUrls((String) source.get("excludedUrls"));
            result.setId((String) source.get("id"));
            result.setIncludedDocUrls((String) source.get("includedDocUrls"));
            result.setIncludedUrls((String) source.get("includedUrls"));
            result.setIntervalTime((Integer) source.get("intervalTime"));
            result.setMaxAccessCount((Long) source.get("maxAccessCount"));
            result.setName((String) source.get("name"));
            result.setNumOfThread((Integer) source.get("numOfThread"));
            result.setSortOrder((Integer) source.get("sortOrder"));
            result.setUpdatedBy((String) source.get("updatedBy"));
            result.setUpdatedTime((Long) source.get("updatedTime"));
            result.setUrls((String) source.get("urls"));
            result.setUserAgent((String) source.get("userAgent"));
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            final String msg = "Cannot create a new instance: " + entityType.getName();
            throw new IllegalBehaviorStateException(msg, e);
        }
    }

    public int selectCount(CBCall<WebConfigCB> cbLambda) {
        return facadeSelectCount(createCB(cbLambda));
    }

    public OptionalEntity<WebConfig> selectEntity(CBCall<WebConfigCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<WebConfig> facadeSelectEntity(WebConfigCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends WebConfig> OptionalEntity<ENTITY> doSelectOptionalEntity(WebConfigCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    public WebConfigCB newConditionBean() {
        return new WebConfigCB();
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return facadeSelectEntity(downcast(cb)).orElse(null);
    }

    public WebConfig selectEntityWithDeletedCheck(CBCall<WebConfigCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    public OptionalEntity<WebConfig> selectByPK(String id) {
        return facadeSelectByPK(id);
    }

    protected OptionalEntity<WebConfig> facadeSelectByPK(String id) {
        return doSelectOptionalByPK(id, typeOfSelectedEntity());
    }

    protected <ENTITY extends WebConfig> ENTITY doSelectByPK(String id, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(id), tp);
    }

    protected WebConfigCB xprepareCBAsPK(String id) {
        assertObjectNotNull("id", id);
        return newConditionBean().acceptPK(id);
    }

    protected <ENTITY extends WebConfig> OptionalEntity<ENTITY> doSelectOptionalByPK(String id, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(id, tp), id);
    }

    @Override
    protected Class<? extends WebConfig> typeOfSelectedEntity() {
        return WebConfig.class;
    }

    @Override
    protected Class<WebConfig> typeOfHandlingEntity() {
        return WebConfig.class;
    }

    @Override
    protected Class<WebConfigCB> typeOfHandlingConditionBean() {
        return WebConfigCB.class;
    }

    public ListResultBean<WebConfig> selectList(CBCall<WebConfigCB> cbLambda) {
        return facadeSelectList(createCB(cbLambda));
    }

    public PagingResultBean<WebConfig> selectPage(CBCall<WebConfigCB> cbLambda) {
        // TODO same?
        return (PagingResultBean<WebConfig>) facadeSelectList(createCB(cbLambda));
    }

    public void insert(WebConfig entity) {
        doInsert(entity, null);
    }

    public void insert(WebConfig entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsert(entity, null);
    }

    public void update(WebConfig entity) {
        doUpdate(entity, null);
    }

    public void update(WebConfig entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doUpdate(entity, null);
    }

    public void insertOrUpdate(WebConfig entity) {
        doInsertOrUpdate(entity, null, null);
    }

    public void insertOrUpdate(WebConfig entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsertOrUpdate(entity, null, null);
    }

    public void delete(WebConfig entity) {
        doDelete(entity, null);
    }

    public void delete(WebConfig entity, RequestOptionCall<DeleteRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().deleteOption(opLambda);
        }
        doDelete(entity, null);
    }

    // TODO create, modify, remove
}