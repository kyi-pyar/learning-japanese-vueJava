<template>
    <v-container>
      <v-row class="text-center">
        <v-col cols="12">
           This is welcome page
           <v-btn @click="fetchKanji()" >
            Button
            </v-btn>

           <pre>
            {{ kanji }}
            
            </pre>
  
        </v-col>
      </v-row>
      <v-row class="text-center">
        <v-col cols="12">
           English Meaning
           <v-btn @click="fetchMeaning()">
            Button
            </v-btn>

           <pre>
            {{ meaning }}
            
            </pre>
  
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  
  export default {
    name: 'WelcomePage',
  
    data: () => ({
        kanji:[],
        meaning:[]
   
}),
methods:{
        
        methodOne(){
            console.log("hello world")
        },
        async fetchKanji() {        
        const resp = await fetch('https://kanjialive-api.p.rapidapi.com/api/public/kanji/all', {
          method: "GET",
          headers:{
          'x-rapidapi-host': 'kanjialive-api.p.rapidapi.com',
          'x-rapidapi-key':'9155db1618msh0e48996e92ed20ep10c960jsn6d399cd4d78c',     
    
          }
          });   
          if (resp && resp.status === 200) {
            const data = await resp.json();
            if (data) {
             this.kanji=data
            }
          }
        },
        async fetchMeaning(){

          const resp = await fetch('https://kanjialive-api.p.rapidapi.com/api/public/kanji/all', {
          method: "GET",
          headers:{
          'x-rapidapi-host': 'kanjialive-api.p.rapidapi.com',
          'x-rapidapi-key':'9155db1618msh0e48996e92ed20ep10c960jsn6d399cd4d78c',     
    
          }
          });   
          if (resp && resp.status === 200) {
            const data = await resp.json();
            if (data) {
             this.meaning=data
             console.log("done", this.meaning)
            }
            else{
              console.log("not match")
            }
          }

        }
        
      }
}
</script>
  