<template>
  <div id="app">
    <!-- <element-view></element-view> -->
    <emp-view></emp-view>
  </div>
</template>

<script>
import EmpView from './views/tlias/EmpView.vue'
// import ElementView from './views/element/ElementView.vue'
export default {
  components: { EmpView },
  // components: { ElementView },
  data() {
    return {
      message: "Hello Vue"
    }
  },
  methods: {

  }
}
</script>

<style>

</style>
