export class Donnation {

    constructor(public name:string,
                public description: string,
                public imageUrl: string,
                public active: boolean,
                public dateCreated: Date,
                public lastUpdated: Date ){

    }
}
