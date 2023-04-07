<template>

    <v-card outlined>
        <v-card-title>
            Acceptoreject
        </v-card-title>

        <v-card-text>
            <Boolean label="Accept" v-model="value.accept" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="acceptoreject"
            >
                Acceptoreject
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'AcceptorejectCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.accept = false;
        },
        watch: {
        },
        methods: {
            acceptoreject() {
                this.$emit('acceptoreject', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

