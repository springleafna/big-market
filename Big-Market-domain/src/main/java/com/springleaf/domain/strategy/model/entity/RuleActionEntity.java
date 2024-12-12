package com.springleaf.domain.strategy.model.entity;


import com.springleaf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * 规则动作实体 其中包含了该规则的code和info表示该规则是放行还是被接管，以及data表示具体的抽奖实体类型。
 * 这个类中的成员变量data的类型是泛型，表示具体的抽奖实体类型，由于抽奖分为以下这几种情况
 * 抽奖之前的实体类型是RaffleBeforeEntity，抽奖中的实体类型是RaffleCenterEntity，抽奖之后的实体类型是RaffleAfterEntity。
 * 所以传入的data的类型只能是这三者中的一种。
 * 因此在这里设定了T extends RuleActionEntity.RaffleEntity，表示data的类型必须是抽奖实体类型。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;

    static public class RaffleEntity {

    }

    // 抽奖之前
    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RaffleBeforeEntity extends RaffleEntity {
        /**
         * 策略ID
         */
        private Long strategyId;

        /**
         * 权重值Key；用于抽奖时可以选择权重抽奖。
         */
        private String ruleWeightValueKey;

        /**
         * 奖品ID；
         */
        private Integer awardId;
    }

    // 抽奖之中
    static public class RaffleCenterEntity extends RaffleEntity {

    }

    // 抽奖之后
    static public class RaffleAfterEntity extends RaffleEntity {

    }

}
