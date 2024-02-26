<script lang="ts">
import {defineComponent} from "vue";
import WeatherService from "@/service/WeatherService";
import BarChart from "@/components/BarChart.vue";
import type WeatherAggregatedRecord from "@/types/WeatherAggregatedRecord";
import type ResponseData from "@/types/ResponseData";

export default defineComponent({
  name: "weather-component",
  components: {BarChart},
  data() {
    return {
      weatherData: [] as WeatherAggregatedRecord[],
    };
  },
  methods: {
    getWeatherDataAll() {
      WeatherService.getWeatherDataAll()
          .then((response: ResponseData) => {
            this.weatherData = (response.data as WeatherAggregatedRecord[]);
          })
          .catch((e: Error) => {
            console.log(e);
          });
    },
  },
  mounted() {
    this.getWeatherDataAll();
  },
});

</script>

<template>
  <h2>DataTable</h2>
  <div class="view">
    <div class="bar-view">
      <BarChart v-if="weatherData && weatherData.length > 0" v-bind:data="weatherData">
      </BarChart>
    </div>
  </div>
</template>

<style scoped lang="css">
.bar-view {
  width: 50%;
  height: 100%;
  margin-top: 1rem;
}
.view {
  display: flex;
  justify-content: center;
}
</style>