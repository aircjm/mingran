<template>
  <TipEditor  v-model="content"/>

</template>

<script>
  import Editor from "../../components/Editor/index";

  export default {
    name: "blogAdd",
    components  : {Editor},
    data() {
      return {
        content: null,
      }
    },
    methods: {
      onEditorChange(e) {
        //内容改变事件
        debugger;
        console.log(e)
        // this.$emit("input", this.content);
      },

    }
  }
</script>

<style scoped>

</style>
