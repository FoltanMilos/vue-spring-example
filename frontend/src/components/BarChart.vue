<template>
  <Bar 
      id="my-chart-id"
      :options="chartOptions"
      :data="chartData"
  />
</template>

<script>
import {Bar} from 'vue-chartjs'
import {BarElement, CategoryScale, Chart as ChartJS, Legend, LinearScale, Title, Tooltip} from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
  name: 'BarChart',
  components: { Bar },
  props: ['data'],
  data() {
    return {
      chartData: {
        labels: this.data.map(ss => ss.name),
        datasets: [ { data: this.data.map(ss => ss.main.temp) } ]
      },
      chartOptions: {
        responsive: true
      }
    }
  },
}
</script>