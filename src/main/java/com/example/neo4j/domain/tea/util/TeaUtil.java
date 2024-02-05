package com.example.neo4j.domain.tea.util;

import com.example.neo4j.domain.tea.Tea;
import com.example.neo4j.domain.tea.relationships.PurchasedWith;

public class TeaUtil {
    public static PurchasedWith findEdge(Tea tea1, Tea tea2) {
        return  tea1.getPurchasedWiths().stream()
                .filter(pw -> pw.getTea().getId().equals(tea2.getId()))
                .findFirst()
                .orElse(
                        tea2.getPurchasedWiths().stream()
                                .filter(pw -> pw.getTea().getId().equals(tea1.getId()))
                                .findFirst()
                                .orElse(null)
                );
    }
}
