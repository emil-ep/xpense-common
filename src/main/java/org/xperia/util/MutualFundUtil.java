package org.xperia.util;

import org.xperia.models.MutualFundDailyData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutualFundUtil {

    public static Map<String, Double> findGrowth(List<MutualFundDailyData> dailyData) {

        Map<String, Double> growthMap = new HashMap<>();

        if (dailyData.size() > 2){
            MutualFundDailyData latestData = dailyData.get(0);
            MutualFundDailyData previousData = dailyData.get(1);

            Double latestNav = Double.parseDouble(latestData.getNav());
            Double previousNav = Double.parseDouble(previousData.getNav());

            growthMap.put("growth", latestNav - previousNav);

            Double growthPercent = ((latestNav - previousNav)/previousNav) * 100;

            growthMap.put("growthPercent", growthPercent);
        }
        return growthMap;
    }
}
