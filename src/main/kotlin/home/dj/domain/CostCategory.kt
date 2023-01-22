package home.dj.domain

import io.micronaut.serde.annotation.Serdeable

@Serdeable
enum class CostCategory {
    COMMUNAL_COST, ELECTRICITY, INTERNET, HEATING, COOLING, COLD_WATER, HOT_WATER, SEWAGE_TREATMENT, WATER_HEATING, OTHER
}