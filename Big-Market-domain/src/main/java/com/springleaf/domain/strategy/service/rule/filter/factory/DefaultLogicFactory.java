package com.springleaf.domain.strategy.service.rule.filter.factory;

import com.springleaf.domain.strategy.model.entity.RuleActionEntity;
import com.springleaf.domain.strategy.service.annotation.LogicStrategy;
import com.springleaf.domain.strategy.service.rule.filter.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 规则工厂
 */
@Service
public class DefaultLogicFactory {

    // logicFilterMap 是一个并发安全的哈希表，用于存储逻辑过滤器，键为逻辑模式的代码，值为实现了 ILogicFilter 接口的对象。
    // 可以通过注解 @LogicStrategy 定义逻辑模式的名称和代码，并通过该名称获取对应的逻辑过滤器。
    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    /*构造函数接受一个逻辑过滤器列表 logicFilters。
    对每个过滤器检查其是否被 LogicStrategy 注解标识。
    如果存在该注解，将其代码（通过 logicMode().getCode() 获取）和对应的过滤器存入 logicFilterMap。*/
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    // 返回这个包含逻辑过滤器的映射
    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WIGHT("rule_weight", "【抽奖前规则】根据抽奖权重返回可抽奖范围KEY", "before"),
        RULE_BLACKLIST("rule_blacklist", "【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回", "before"),
        RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后，对应奖品可解锁抽奖", "center"),
        RULE_LUCK_AWARD("rule_luck_award", "【抽奖后规则】幸运奖兜底", "after"),
        ;

        private final String code;
        private final String info;
        private final String type;

        public static boolean isCenter(String code){
            return "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }

        public static boolean isAfter(String code){
            return "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }

    }

}
