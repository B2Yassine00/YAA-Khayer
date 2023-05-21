export class Donnation {

    constructor(public id:number,
                public name:string,
                public description: string,
                public imageUrl: string,
                public active: boolean,
                public dateCreated: Date,
                public lastUpdated: Date ){

    }
}
